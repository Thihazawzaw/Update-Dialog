package thihazawzaw.updatedialog.updatedialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AlertDialog;

public class UpdateDialog {
  private String link;
  private int icon;
  private int vcode;
  public Context c;



    public UpdateDialog(Context c, String link, int icon, int vcode) {
        this.c = c;
        this.link = link;
        this.icon = icon;
        this.vcode = vcode;
        new DownloadTask().execute(link);
    }

    private class DownloadTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... p1)
        {
            String result=JSONDownloader.download(p1[0]);
            return result;
        }

        @Override
        public void onPostExecute(String result) {

            processJSON(result);
        }
    }

    private void processJSON(String input) {

        if (!NetTest()) {
            Toast.makeText(c,"No Internet!",Toast.LENGTH_LONG).show();

        } else {


            try {
                JSONObject jo = new JSONObject(input);
                JSONArray ja = jo.getJSONObject("feed").getJSONArray("entry");
                JSONObject jo2;
                for (int i = 0; i < ja.length(); i++) {
                    jo2 = ja.getJSONObject(i);
                    if (jo2.getJSONObject("title").getString("$t").equals("UPDATEZ")) {
                        String content = jo2.getJSONObject("content").getString("$t");
                        JSONObject appupdate = new JSONObject(Html.fromHtml(content).toString());
                        String appname = (appupdate.getString("appname"));
                        String msg = (appupdate.getString("msg"));
                        String versionCode = (appupdate.getString("versionCode"));
                        final String link = (appupdate.getString("link"));
                        final String playstore = (appupdate.getString("playstore"));



                        int version = Integer.parseInt(versionCode);

                        if (vcode < version) {

                            AlertDialog.Builder alert = new AlertDialog.Builder(c);
                            alert.setCancelable(true);
                            alert.setTitle(appname);
                            alert.setMessage(msg);
                            alert.setIcon(icon);
                            alert.setPositiveButton("Update Download", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                                            Uri.parse(link));
                                    c.startActivity(browserIntent);
                                    dialog.dismiss();
                                }
                            });
                            if ((playstore.length()) > 5) {
                                alert.setNegativeButton("PlayStore", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Intent i = new Intent(Intent.ACTION_VIEW,
                                                Uri.parse(playstore));
                                        c.startActivity(i);
                                        dialog.dismiss();

                                    }
                                });
                            }

                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();
                        }
                        else {
                            Toast.makeText(c,"This app is update version!",Toast.LENGTH_LONG).show();
                        }
                        break;
                    }
                }
            } catch (JSONException e) {

            }
        }
    }




    private boolean NetTest() {
        ConnectivityManager connectivityManager = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }


}

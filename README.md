# Update-Dialo
Unicode
ယခု library လေးအား စမ်းပြီးတင်ခြင်းဖြစ်ပါသည်။
ယခု libs စတင် အသုံးပြုမယ်ဆိုရင်

#ပထမ အဆင့် 
*************

blogger တွင် 
အောက်ပါ အတိုင်း post တစ်ခုတင်ပေးပါ။

    Blog Post title ကို  UPDATEZ လို့ အတိအကျပေးရပါမယ်။

blog post body ရဲ့ Html ဘက်မှာ အောက်ပါ Json string ထည့်ပေးရပါမယ်။

      { "appname":"ကိုယ့် ရဲ့app name",

      "versionCode":"1",

      "msg":"Update version နဲ့ ပတ်သတ်တဲ့ စာ တစ်ခုခုရေး ",

      "link":"app download link ထည့်" ,

      "playstore":"PlayStore လင့်ရှိရင်ထည့် မရှိရင်ဘာမှမထည့်နဲ့"

       }


Version code ကို ပထမ version ဆိုလျှင်  1 ပဲ ထားပါ။
ဒုတိယ versionဆိုလျှင် 2 လို့ပြောင်းပေး ပြီး update download link ထည့်ပေးရပါမယ်။

#ဒုတိယ အဆင့် 
************
build.gradle (project level)မှာ
	
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
build.gradle (app level)မှာ

          dependencies {
	          implementation 'com.github.Thihazawzaw:Update-Dialog:1.0'
	     }


AndroidManifest.xml မှာအောက်ပါအတိုင်းထည့်ပေးပါ။


      <manifest
        .......... >
  
         <uses-permission android:name="android.permission.INTERNET"/>
         <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>  
             <application
             ............
              ..............
              android:usesCleartextTraffic="true"
                >
             <activity >
               ..................
            </activity>
              <uses-library android:name="org.apache.http.legacy" android:required="false"/>
       </application>
       </manifest>
    

#တတိယ အဆင့်
***********
ကိုယ် ခေါ်သုံးချင်တဲ့ Activityရဲ့ OnCreate Method မှာ
အောက်ပါအတိုင်းခေါ်သုံး လို့ရပါပြီ
       
       String link="https://myblog.blogspot.com/feeds/posts/default?alt=json";
       int icon=R.drawable.ic_launcher_background;
       /*second update ပေးလျှင် vcode ကို 2 ပြောင်းပေးပြီး blog post မှာပါ ပြောင်းပါ
      */
        int vcode=1;
        UpdateDialog updateDialog=new UpdateDialog(MainActivity.this,link,icon,vcode);


Zawgyi

ယခု library ေလးအား စမ္းျပီးတင္ျခင္းျဖစ္ပါသည္။
ယခု libs စတင္ အသံုးျပုမယ္ဆိုရင္

#ပထမ အဆင့္ 
*************

blogger တြင္ 
ေအာက္ပါ အတိုင္း post တစ္ခုတင္ေပးပါ။

     Blog Post title ကို  UPDATEZ လို႕ အတိအက်ေပးရပါမယ္။

blog post body ရဲ႕ Html ဘက္မွာ ေအာက္ပါ Json string ထည္႕ေပးရပါမယ္။

    { "appname":"ကိုယ္႕ ရဲ႕app name",

    "versionCode":"1",

    "msg":"Update version နဲ႕ ပတ္သတ္တဲ႕ စာ တစ္ခုခုေရး ",

    "link":"app download link ထည္႕" ,

    "playstore":"PlayStore လင္႔ရွိရင္ထည္႕ မရွိရင္ဘာမွမထည္႕နဲ႕"

    }


Version code ကို ပထမ version ဆိုလ်ွင္  1 ပဲ ထားပါ။
ဒုတိယ versionဆိုလ်ွင္ 2 လို႕ေျပာင္းေပး ျပီး update download link ထည္႔ေပးရပါမယ္။

#ဒုတိယ အဆင့္ 
************
        
	build.gradle (project level)မွာ
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
build.gradle (app level)မွာ
      
      dependencies {
	          implementation 'com.github.Thihazawzaw:Update-Dialog:1.0'
	    }

AndroidManifest.xml မွာေအာက္ပါအတိုင္းထည္႔ေပးပါ။

      <manifest
      ...........>
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <application
       ............
      ..............
        android:usesCleartextTraffic="true"
       >
        <activity >
          ..................
        </activity>
        <uses-library android:name="org.apache.http.legacy" android:required="false"/>
    </application>
    </manifest>

#တတိယ အဆင့္
***********
ကိုယ္ ေခါ္သံုးခ်င္တဲ႕ Activityရဲ႕ OnCreate Method မွာ
ေအာက္ပါအတိုင္းေခါ္သံုး လို႕ရပါျပီ
       
       String link="https://myblog.blogspot.com/feeds/posts/default?alt=json";
        int icon=R.drawable.ic_launcher_background;
       /*second update ေပးလ်ွင္ vcode ကို 2 ေျပာင္းေပးျပီး blog post မွာပါ ေျပာင္းပါ
      */
        int vcode=1;
        UpdateDialog updateDialog=new UpdateDialog(MainActivity.this,link,icon,vcode);




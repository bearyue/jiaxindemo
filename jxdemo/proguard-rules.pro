# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\Android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-dontwarn org.jxmpp.**
-dontwarn com.jxccp.**
-dontwarn de.measite.minidns.**
-dontwarn org.jivesoftware.smack.**
-dontwarn org.jivesoftware.smackx.**
-dontwarn android.support.v4.**
-dontwarn android.support.v7.**

-keep class de.measite.minidns.** {*;}
-keep class org.jivesoftware.smack.** {*;}
-keep class org.jivesoftware.smackx.** {*;}
-keep class org.jxmpp.** {*;}
-keep class com.jxccp.** {*;}
# Keep the support library
-keep class android.support.v4.** { *; }
-keep interface android.support.v4.** { *; }
# Keep the support library
-keep class android.support.v7.** { *; }
-keep interface android.support.v7.** { *; }
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

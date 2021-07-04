package dependency

object Build {
    val build_tools = "com.android.tools.build:gradle:${Version.gradle}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    val google_services = "com.google.gms:google-services:${Version.play_services}"
    val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Version.mannodermaus_junit5}"
    val crashlytics_gradle = "com.google.firebase:firebase-crashlytics-gradle:${Version.crashlytics_gradle}"
}
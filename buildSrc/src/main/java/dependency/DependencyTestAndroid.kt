package dependency

object DependencyTestAndroid{

    val kotlin_test = "org.jetbrains.kotlin:kotlin-test-junit:${Version.kotlin}"
    val coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines_version}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Version.espresso_core}"
    val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Version.espresso_core}"
    val idling_resource = "androidx.test.espresso:espresso-idling-resource:${Version.espresso_idling_resource}"
    val test_runner = "androidx.test:runner:${Version.test_runner}"
    val test_rules = "androidx.test:rules:${Version.test_runner}"
    val text_core_ktx = "androidx.test:core-ktx:${Version.test_core}"
    val mockk_android = "io.mockk:mockk-android:${Version.mockk_version}"
    val fragment_testing = "androidx.fragment:fragment-testing:${Version.fragment_version}"
    val androidx_test_ext = "androidx.test.ext:junit-ktx:${Version.androidx_test_ext}"
    val navigation_testing = "androidx.navigation:navigation-testing:${Version.nav_components}"

    val instrumentation_runner = "com.sean.oppnet.framework.MockTestRunner"
}
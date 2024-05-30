package com.monosoft.ecommercebenja

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//esta clase se crea para poder inyectar las dependencias e indicar que estamos utilizando hilt
@HiltAndroidApp
class EcommerceBenja :Application() {
}
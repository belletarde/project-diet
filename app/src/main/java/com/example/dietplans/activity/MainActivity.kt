package com.example.dietplans.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dietplans.R
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = SplitInstallManagerFactory.create(this)
        SplitCompat.install(this)

        var request: SplitInstallRequest =
            SplitInstallRequest
                .newBuilder()
                // You can download multiple on demand modules per
                // request by invoking the following method for each
                // module you want to install.
                .addModule("diet_plan")
                .build()

        // Skip loading if the module already is installed. Perform success action directly.
        if (manager.installedModules.contains("diet_plan")) {
            //updateProgressMessage("Already installed")
            onSuccessfulLoad("diet_plan", launch = true)
        }

        manager.startInstall(request)
    }

    private fun onSuccessfulLoad(moduleName: String, launch: Boolean) {
        if (launch) {
            Toast.makeText(this,"Onsuccessfulload", Toast.LENGTH_SHORT).show()

            var intent1 = Intent(this, Class.forName("com.tech.fit.diet_plan.activity.MainActivity"))
            startActivity(intent1)
        }
    }
}

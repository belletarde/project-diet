package belletarde.test.dietplans.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import belletarde.test.dietplans.R
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import kotlinx.android.synthetic.main.default_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.default_activity_main)
        val manager = SplitInstallManagerFactory.create(this)
        SplitCompat.install(this)

        btnStartModule.setOnClickListener {
            var request: SplitInstallRequest =
                SplitInstallRequest
                    .newBuilder()
                    .addModule("diet_plan")
                    .build()

            if (manager.installedModules.contains("diet_plan")) {
                //updateProgressMessage("Already installed")
                onSuccessfulLoad()
            }

            manager.startInstall(request)
        }

    }

    private fun onSuccessfulLoad(launch: Boolean = true) {
        if (launch) {
            Toast.makeText(this,"Onsuccessfulload", Toast.LENGTH_SHORT).show()

            var intent1 = Intent(this, Class.forName("belletarde.tech.fit.diet_plan.activity.MainDietActivity"))
            startActivity(intent1)
        }
    }
}

package np.com.yipl.collectr

import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_dashboard.*
import np.com.yipl.yipl_collect.YiplFormEntryActivity
import np.com.yipl.yipl_collect.YiplMainMenuActivity
import org.odk.collect.android.activities.FormEntryActivity
import org.odk.collect.android.activities.MainMenuActivity
import org.odk.collect.android.application.Collect
import org.odk.collect.android.dao.FormsDao
import org.odk.collect.android.provider.FormsProviderAPI
import org.odk.collect.android.utilities.ApplicationConstants

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        button_main_menu.setOnClickListener {
            startActivity(Intent(this, MainMenuActivity::class.java))
        }

        root_activity.rootView.findNavController().addOnDestinationChangedListener{ _, destination, _ ->
            if (destination.id == R.id.login_graph) {

            }
        }

        button_form_entry.setOnClickListener {
            var formId: Long? = null
            val cursor =  FormsDao().formsCursor

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    val title = cursor.getString(cursor.getColumnIndex(FormsProviderAPI.FormsColumns.DISPLAY_NAME))
                    formId = cursor.getLong(cursor.getColumnIndex(BaseColumns._ID))
                } while (cursor.moveToNext())
            }

            formId?.let { id ->

                val formUri = ContentUris.withAppendedId(FormsProviderAPI.FormsColumns.CONTENT_URI, id)

                startActivity(Intent(this, YiplFormEntryActivity::class.java).apply {
                    action = Intent.ACTION_EDIT
                    data = formUri
                    putExtra(ApplicationConstants.BundleKeys.FORM_MODE, ApplicationConstants.FormModes.EDIT_SAVED)
                })

//                Intent(this, MainMenuActivity::class.java).run {
//                    action = Intent.ACTION_EDIT
//                    data = formUri
//                    putExtra(ApplicationConstants.BundleKeys.FORM_MODE, ApplicationConstants.FormModes.EDIT_SAVED)
//                    startActivity(intent)
//                }

            } ?: Toast.makeText(this, "NO id found", Toast.LENGTH_LONG).show()
        }
    }
}

package np.com.yipl.yipl_collect

import android.content.Context
import org.javarosa.form.api.FormEntryCaption
import org.javarosa.form.api.FormEntryPrompt
import org.odk.collect.android.activities.FormEntryActivity
import org.odk.collect.android.views.ODKView

class YiplFormEntryActivity: FormEntryActivity() {

    override fun createODKView(context: Context, prompts: Array<FormEntryPrompt>, groups: Array<FormEntryCaption>, advancingPage: Boolean): ODKView {
        return YiplODKView(context, prompts, groups, advancingPage)
    }
}




package np.com.yipl.yipl_collect.widget

import android.content.Context
import androidx.core.content.ContextCompat
import np.com.yipl.yipl_collect.R
import org.javarosa.form.api.FormEntryPrompt
import org.odk.collect.android.widgets.StringWidget

class YiStringWidget(
        context: Context,
        prompt: FormEntryPrompt,
        readOnlyOverride: Boolean
): StringWidget(context, prompt, readOnlyOverride) {

    override fun formatWidget() {
        answerTextField.setTextColor(ContextCompat.getColor(context, R.color.amber_500))
    }

}
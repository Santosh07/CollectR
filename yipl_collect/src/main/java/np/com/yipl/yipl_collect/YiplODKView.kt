package np.com.yipl.yipl_collect

import android.content.Context
import org.javarosa.form.api.FormEntryCaption
import org.javarosa.form.api.FormEntryPrompt
import org.odk.collect.android.views.ODKView
import org.odk.collect.android.widgets.QuestionWidget

class YiplODKView(
        context: Context,
        questionPrompt: Array<FormEntryPrompt>,
        groups: Array<FormEntryCaption>,
        advancingPage: Boolean): ODKView(context, questionPrompt, groups, advancingPage) {


    override fun createQuestionWidget(question: FormEntryPrompt, readOnlyOverride: Boolean): QuestionWidget {
        return createWidgetFromPrompt(question, context, readOnlyOverride)
    }
}
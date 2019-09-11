package np.com.yipl.yipl_collect

import android.content.Context
import np.com.yipl.yipl_collect.widget.YiStringWidget
import org.javarosa.core.model.Constants
import org.javarosa.form.api.FormEntryPrompt
import org.odk.collect.android.utilities.WidgetAppearanceUtils
import org.odk.collect.android.widgets.*

fun createWidgetFromPrompt(fep: FormEntryPrompt, context: Context,
                           readOnlyOverride: Boolean): QuestionWidget {

    val appearance = WidgetAppearanceUtils.getSanitizedAppearanceHint(fep)

    val questionWidget: QuestionWidget
    when (fep.controlType) {
        Constants.CONTROL_INPUT ->
            when (fep.dataType) {
            Constants.DATATYPE_DATE_TIME -> questionWidget = DateTimeWidget(context, fep)
            Constants.DATATYPE_DATE -> questionWidget = DateWidget(context, fep)
            Constants.DATATYPE_TIME -> questionWidget = TimeWidget(context, fep)
            Constants.DATATYPE_DECIMAL -> if (appearance.startsWith(WidgetAppearanceUtils.EX)) {
                questionWidget = ExDecimalWidget(context, fep)
            } else if (appearance == WidgetAppearanceUtils.BEARING) {
                questionWidget = BearingWidget(context, fep)
            } else {
                questionWidget = DecimalWidget(context, fep, readOnlyOverride,
                        appearance.contains(WidgetAppearanceUtils.THOUSANDS_SEP))
            }
            Constants.DATATYPE_INTEGER -> if (appearance.startsWith(WidgetAppearanceUtils.EX)) {
                questionWidget = ExIntegerWidget(context, fep)
            } else {
                questionWidget = IntegerWidget(context, fep, readOnlyOverride,
                        appearance.contains(WidgetAppearanceUtils.THOUSANDS_SEP))
            }
            Constants.DATATYPE_GEOPOINT -> questionWidget = GeoPointWidget(context, fep)
            Constants.DATATYPE_GEOSHAPE -> questionWidget = GeoShapeWidget(context, fep)
            Constants.DATATYPE_GEOTRACE -> questionWidget = GeoTraceWidget(context, fep)
            Constants.DATATYPE_BARCODE -> questionWidget = BarcodeWidget(context, fep)
            Constants.DATATYPE_TEXT -> {
                val query = fep.question.getAdditionalAttribute(null, "query")
                if (query != null) {
                    questionWidget = ItemsetWidget(context, fep, appearance.startsWith(WidgetAppearanceUtils.QUICK))
                } else if (appearance.startsWith(WidgetAppearanceUtils.PRINTER)) {
                    questionWidget = ExPrinterWidget(context, fep)
                } else if (appearance.startsWith(WidgetAppearanceUtils.EX)) {
                    questionWidget = ExStringWidget(context, fep)
                } else if (appearance.contains(WidgetAppearanceUtils.NUMBERS)) {
                    questionWidget = StringNumberWidget(context, fep, readOnlyOverride,
                            appearance.contains(WidgetAppearanceUtils.THOUSANDS_SEP))
                } else if (appearance == WidgetAppearanceUtils.URL) {
                    questionWidget = UrlWidget(context, fep)
                } else {
                    questionWidget = YiStringWidget(context, fep, readOnlyOverride)
                }
            }
            Constants.DATATYPE_BOOLEAN -> questionWidget = BooleanWidget(context, fep)
            else -> questionWidget = StringWidget(context, fep, readOnlyOverride)
        }
        Constants.CONTROL_FILE_CAPTURE -> questionWidget = ArbitraryFileWidget(context, fep)
        Constants.CONTROL_IMAGE_CHOOSE -> if (appearance == WidgetAppearanceUtils.SIGNATURE) {
            questionWidget = SignatureWidget(context, fep)
        } else if (appearance.contains(WidgetAppearanceUtils.ANNOTATE)) {
            questionWidget = AnnotateWidget(context, fep)
        } else if (appearance == WidgetAppearanceUtils.DRAW) {
            questionWidget = DrawWidget(context, fep)
        } else {
            questionWidget = ImageWidget(context, fep)
        }
        Constants.CONTROL_OSM_CAPTURE -> questionWidget = OSMWidget(context, fep)
        Constants.CONTROL_AUDIO_CAPTURE -> questionWidget = AudioWidget(context, fep)
        Constants.CONTROL_VIDEO_CAPTURE -> questionWidget = VideoWidget(context, fep)
        Constants.CONTROL_SELECT_ONE ->
            // search() appearance/function (not part of XForms spec) added by SurveyCTO gets
            // considered in each widget by calls to ExternalDataUtil.getSearchXPathExpression.
            // This means normal appearances should be put before search().
            if (!appearance.startsWith(WidgetAppearanceUtils.COMPACT_N) && (appearance.startsWith(WidgetAppearanceUtils.COMPACT)
                            || appearance.startsWith(WidgetAppearanceUtils.QUICKCOMPACT)
                            || appearance.startsWith(WidgetAppearanceUtils.COLUMNS_PACK))) {
                questionWidget = GridWidget(context, fep, appearance.contains(WidgetAppearanceUtils.QUICK))
            } else if (appearance.contains(WidgetAppearanceUtils.MINIMAL)) {
                questionWidget = SpinnerWidget(context, fep, appearance.contains(WidgetAppearanceUtils.QUICK))
            } else if (appearance.contains(WidgetAppearanceUtils.SEARCH) || appearance.contains(WidgetAppearanceUtils.AUTOCOMPLETE)) {
                questionWidget = SelectOneSearchWidget(context, fep, appearance.contains(WidgetAppearanceUtils.QUICK))
            } else if (appearance.contains(WidgetAppearanceUtils.LIST_NO_LABEL)) {
                questionWidget = ListWidget(context, fep, false, appearance.contains(WidgetAppearanceUtils.QUICK))
            } else if (appearance.contains(WidgetAppearanceUtils.LIST)) {
                questionWidget = ListWidget(context, fep, true, appearance.contains(WidgetAppearanceUtils.QUICK))
            } else if (appearance == WidgetAppearanceUtils.LABEL) {
                questionWidget = LabelWidget(context, fep)
            } else if (appearance.contains(WidgetAppearanceUtils.IMAGE_MAP)) {
                questionWidget = SelectOneImageMapWidget(context, fep, appearance.contains(WidgetAppearanceUtils.QUICK))
            } else {
                questionWidget = SelectOneWidget(context, fep, appearance.contains(WidgetAppearanceUtils.QUICK))
            }
        Constants.CONTROL_SELECT_MULTI ->
            // search() appearance/function (not part of XForms spec) added by SurveyCTO gets
            // considered in each widget by calls to ExternalDataUtil.getSearchXPathExpression.
            // This means normal appearances should be put before search().
            if (!appearance.startsWith(WidgetAppearanceUtils.COMPACT_N) && (appearance.startsWith(WidgetAppearanceUtils.COMPACT) || appearance.startsWith(WidgetAppearanceUtils.COLUMNS_PACK))) {
                questionWidget = GridMultiWidget(context, fep)
            } else if (appearance.startsWith(WidgetAppearanceUtils.MINIMAL)) {
                questionWidget = SpinnerMultiWidget(context, fep)
            } else if (appearance.startsWith(WidgetAppearanceUtils.LIST_NO_LABEL)) {
                questionWidget = ListMultiWidget(context, fep, false)
            } else if (appearance.startsWith(WidgetAppearanceUtils.LIST)) {
                questionWidget = ListMultiWidget(context, fep, true)
            } else if (appearance.startsWith(WidgetAppearanceUtils.LABEL)) {
                questionWidget = LabelWidget(context, fep)
            } else if (appearance.contains(WidgetAppearanceUtils.SEARCH) || appearance.contains(WidgetAppearanceUtils.AUTOCOMPLETE)) {
                questionWidget = SelectMultipleAutocompleteWidget(context, fep)
            } else if (appearance.startsWith(WidgetAppearanceUtils.IMAGE_MAP)) {
                questionWidget = SelectMultiImageMapWidget(context, fep)
            } else {
                questionWidget = SelectMultiWidget(context, fep)
            }
        Constants.CONTROL_RANK -> questionWidget = RankingWidget(context, fep)
        Constants.CONTROL_TRIGGER -> questionWidget = TriggerWidget(context, fep)
        Constants.CONTROL_RANGE -> if (appearance.startsWith(WidgetAppearanceUtils.RATING)) {
            questionWidget = RatingWidget(context, fep)
        } else {
            when (fep.dataType) {
                Constants.DATATYPE_INTEGER -> questionWidget = RangeIntegerWidget(context, fep)
                Constants.DATATYPE_DECIMAL -> questionWidget = RangeDecimalWidget(context, fep)
                else -> questionWidget = StringWidget(context, fep, readOnlyOverride)
            }
        }
        else -> questionWidget = StringWidget(context, fep, readOnlyOverride)
    }

    return questionWidget
}
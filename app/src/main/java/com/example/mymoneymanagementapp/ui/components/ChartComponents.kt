package com.example.mymoneymanagementapp.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymoneymanagementapp.ui.theme.MyMoneyManagementAppTheme
import com.example.mymoneymanagementapp.utils.marker
import com.patrykandpatryk.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatryk.vico.compose.axis.vertical.startAxis
import com.patrykandpatryk.vico.compose.chart.Chart
import com.patrykandpatryk.vico.compose.chart.entry.plus
import com.patrykandpatryk.vico.compose.chart.line.lineChart
import com.patrykandpatryk.vico.compose.chart.line.lineSpec
import com.patrykandpatryk.vico.compose.component.shape.shader.verticalGradient
import com.patrykandpatryk.vico.compose.style.ChartStyle
import com.patrykandpatryk.vico.compose.style.ProvideChartStyle
import com.patrykandpatryk.vico.core.DefaultColors
import com.patrykandpatryk.vico.core.chart.composed.plus
import com.patrykandpatryk.vico.core.entry.ChartEntryModel
import com.patrykandpatryk.vico.core.entry.entriesOf
import com.patrykandpatryk.vico.core.entry.entryModelOf

private val entityColors = longArrayOf(0xFFAA96DA)
private const val PERSISTENT_MARKER_X = 6f

@Composable
fun ChartComponents(
    model: ChartEntryModel
) {
    val startAxis = startAxis()
    val bottomAxis = bottomAxis(guideline = null)
    val chartStyle = ChartStyle.fromEntityColors(entityColors = entityColors)
    ProvideChartStyle(chartStyle) {
        val lineChart = lineChart(persistentMarkers = mapOf(PERSISTENT_MARKER_X to marker()))
        Chart(
            chart = lineChart, model = model,
            startAxis = startAxis, bottomAxis = bottomAxis, marker = marker()
        )
    }
}

private val model1 = entryModelOf(0, 2, 4, 0, 2)
private val model2 = entryModelOf(1, 3, 4, 1, 3)
private val model3 = entryModelOf(entriesOf(3, 2, 2, 3, 1), entriesOf(1, 3, 1, 2, 3))

@Preview(widthDp = 200)
@Composable
fun RegularLineChart() {
    Chart(chart = lineChart(), model = model1, startAxis = startAxis())
}

@Preview("Line Chart Expanded", widthDp = 200)
@Composable
public fun RegularLineChartExpanded() {
    Chart(
        chart = lineChart(
            minY = -1f,
            maxY = 5f,
        ),
        model = model1,
        startAxis = startAxis(),
    )
}

@Preview("Line Chart Collapsed", widthDp = 200)
@Composable
public fun RegularLineChartCollapsed() {
    Chart(
        chart = lineChart(
            minY = 1f,
            maxY = 3f,
        ),
        model = model1,
        startAxis = startAxis(),
    )
}

@Preview("Composed Chart", widthDp = 200)
@Composable
public fun ComposedLineChart() {
    Chart(
        chart = lineChart() + lineChart(
            lines = listOf(
                lineSpec(
                    lineColor = Color.Blue,
                    lineBackgroundShader = verticalGradient(
                        colors = arrayOf(
                            Color.Blue.copy(alpha = 0.4f),
                            Color.Blue.copy(alpha = 0f),
                        ),
                    ),
                ),
            ),
        ),
        model = model1 + model2,
        startAxis = startAxis(),
    )
}

@Preview("Composed Chart Collapsed", widthDp = 200)
@Composable
public fun ComposedLineChartCollapsed() {
    Chart(
        chart = (lineChart() + lineChart())
            .apply {
                minY = 1f
                maxY = 3f
            },
        model = model1 + model2,
        startAxis = startAxis(),
    )
}

@Preview
@Composable
fun ChartComponentsPreview(){
    MyMoneyManagementAppTheme{
        ChartComponents(model = model1)
    }
}

@Composable
internal fun ChartStyle.Companion.fromEntityColors(entityColors: LongArray): ChartStyle {
    val defaultColors = if (isSystemInDarkTheme()) DefaultColors.Dark else DefaultColors.Light
    return fromColors(
        axisLabelColor = Color(defaultColors.axisLabelColor),
        axisGuidelineColor = Color(defaultColors.axisGuidelineColor),
        axisLineColor = Color(defaultColors.axisLineColor),
        entityColors = entityColors.map(::Color),
        elevationOverlayColor = Color(defaultColors.elevationOverlayColor),
    )
}
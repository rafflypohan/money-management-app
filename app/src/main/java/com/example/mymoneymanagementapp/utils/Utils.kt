package com.example.mymoneymanagementapp.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import java.text.SimpleDateFormat
import java.util.*

fun Long.toCurrencyFormat(): String{
    return "Rp %,d".format(this).replace(",", ".")
}

fun Modifier.ignoreHorizontalParentPadding(horizontal: Dp): Modifier {
    return this.layout { measurable, constraints ->
        val overridenWidth = constraints.maxWidth + 2 * horizontal.roundToPx()
        val placeable = measurable.measure(constraints.copy(maxWidth = overridenWidth))
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}

fun Date.formatDateToString(): String {
    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    return formatter.format(this)
}

fun String.formatStringToDate(): Date{
    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    return if (this.isNotBlank()){
        formatter.parse(this) as Date
    } else {
        formatter.parse("01 January 2000") as Date
    }
}

fun getCurrentDate(): Date{
    return Calendar.getInstance().time
}
package h.car2.util

import h.car2.wWidth


const val lineWidth = wWidth / 4

const val halfLine = lineWidth / 2


fun centerOfLine(index: Int) = ((index - 1) * lineWidth) + halfLine
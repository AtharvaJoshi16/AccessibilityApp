package com.programming_simplified.alarmclock.features.ui.screens.component

import android.hardware.lights.Light
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming_simplified.alarmclock.common.CommonLine
import com.programming_simplified.alarmclock.common.CustomToggleButton
import kotlin.random.Random


@Composable
fun AlarmEachRow(number: Int,number2: Int) {

    var selected by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp).semantics { contentDescription = "Alarm for, ${number}:00, " + when (number2) {
                0 -> "Ring Once"
                1 -> "Repeat"
                else -> "Daily"
            } + "," + if(selected) "Active" else "Inactive"
              },
        shape = RoundedCornerShape(12.dp),
        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (selected) Color.White else Color.White.copy(0.6f)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = if (number.toString().length == 1){
                             "0$number:00"
                                }else{
                            "$number:00"
                             }, style = TextStyle(
                            color = if (selected) Color.Black else Color.LightGray,
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = when (number2) {
                            0 -> {
                                "Ring Once"
                            }
                            1 -> {
                                "Repeat"
                            }
                            else -> {
                                "Daily"
                            }
                        }, style = TextStyle(
                            color = if (selected) Color.Gray else Color.LightGray,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                Row(
                    modifier = Modifier.align(CenterVertically)
                ) {
                    CommonLine(
                        width = 0.5.dp, height = 20.dp, modifier = Modifier.align(CenterVertically)
                    )
                    CustomToggleButton(
                        selected = selected, modifier = Modifier.padding(start = 10.dp)
                            .clearAndSetSemantics {
                                role = Role.Switch
                                stateDescription = if(selected) "Active" else "Inactive"
                                 }
                    ) {
                        selected = it
                    }
                }
            }

        }
    }

}
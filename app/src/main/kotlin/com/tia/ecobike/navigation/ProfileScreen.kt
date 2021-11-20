package com.tia.ecobike.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionLayoutDebugFlags
import androidx.constraintlayout.compose.MotionScene
import java.util.*

@Composable
fun ProfileScreens() {
    var animateToEnd by remember { mutableStateOf(false) }

    val progress by animateFloatAsState(
        targetValue = if (animateToEnd) 1f else 0f,
        animationSpec = tween(2000)
    )
    Column {
        MotionLayout(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.White),
            motionScene = MotionScene("""{
                ConstraintSets: {   // all ConstraintSets
                  start: {          // constraint set id = "start"
                    a: {            // Constraint for widget id='a'
                      width: 40,
                      height: 40,
                      start: ['parent', 'start', 16],
                      bottom: ['parent', 'bottom', 16]
                    }
                  },
                  end: {         // constraint set id = "start"
                    a: {
                      width: 20,
                      height: 20,
                      //rotationZ: 390,
                      end: ['parent', 'end', 16],
                      top: ['parent', 'top', 16]
                    }
                  }
                },
                Transitions: {            // All Transitions in here 
                  default: {              // transition named 'default'
                    from: 'start',        // go from Transition "start"
                    to: 'end',            // go to Transition "end"
                    pathMotionArc: 'startHorizontal',  // move in arc 
                    KeyFrames: {          // All keyframes go here
                      KeyAttributes: [    // keyAttributes key frames go here
                        {
                          target: ['a'],              // This keyAttributes group target id "a"
                          frames: [25,50,75],         // 3 points on progress 25% , 50% and 75%
                          rotationX: [0, 45, 60],     // the rotationX angles are a spline from 0,0,45,60,0
                          rotationY: [60, 45, 0],     // the rotationX angles are a spline from 0,60,45,0,0
                        }
                      ]
                    }
                  }
                }
            }"""),
            debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL),
            progress = progress) {
            Box(modifier = Modifier
                .layoutId("a")
                .background(Color.Red))
        }

        Button(onClick = { animateToEnd = !animateToEnd }) {
            Text(text = "Run")
        }
    }
}

@Preview
@Composable
fun previews() {
    ProfileScreens()
}
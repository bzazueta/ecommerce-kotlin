package com.monosoft.ecommercemono.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.monosoft.ecommercemono.presentation.ui.theme.Blue500
import com.monosoft.ecommercemono.presentation.ui.theme.EcommerceBenjaTheme
import com.monosoft.ecommercemono.presentation.ui.theme.White

@Composable
fun DefaultButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color = Blue500,

) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = White
        ),
        shape = RectangleShape,
    ) {
        Text(
            text = text,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultButtonPreview() {
    EcommerceBenjaTheme {
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Iniciar Sesion",
            onClick = { /*TODO*/ },
            color = Blue500
        )
    }
}
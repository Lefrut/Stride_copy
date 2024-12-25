package com.application.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.application.ui.theme.labelMediumLow


@Composable
fun StrideOutlineButton(
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.labelMedium,
    modifier: Modifier = Modifier,
    onClink: () -> Unit,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        contentColor = MaterialTheme.colorScheme.outline,
    ),
    shape: Shape = MaterialTheme.shapes.large,
    paddingValues: PaddingValues = PaddingValues(13.dp),
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    border: BorderStroke? = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClink,
        shape = shape,
        contentPadding = paddingValues,
        colors = colors,
        border = border,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}


@Composable
fun StrideButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.background
    )
){
    FilledTonalButton(
        modifier = modifier.sizeIn(minHeight = 45.dp),
        onClick = onClick,
        contentPadding = paddingValues,
        shape = shape,
        colors = colors
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun StrideTextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.labelMediumLow,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        contentColor = MaterialTheme.colorScheme.outlineVariant
    ),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 13.dp, vertical = 2.dp),
    interactionSource: MutableInteractionSource? = null,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        contentPadding = contentPadding,
        colors = colors,
        border = border,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}
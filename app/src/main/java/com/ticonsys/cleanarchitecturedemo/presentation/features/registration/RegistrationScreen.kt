package com.ticonsys.cleanarchitecturedemo.presentation.features.registration

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ticonsys.cleanarchitecturedemo.domain.usecases.Route
import kotlinx.coroutines.flow.collect

@Composable
fun RegistrationScreen(
    viewModel: RegistrationViewModel = hiltViewModel(),
    navigate: (route: String) -> Unit
) {
    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collect { event ->
            when (event) {
                ValidationEvent.Success -> {
                    navigate(Route.Home.route)
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = state.email,
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.EmailChanged(it))
            },
            isError = state.emailError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Email")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        if (state.emailError != null) {
            Text(
                text = state.emailError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.password,
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.PasswordChanged(it))
            },
            isError = state.passwordError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        if (state.passwordError != null) {
            Text(
                text = state.passwordError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.repeatedPassword,
            onValueChange = {
                viewModel.onEvent(RegistrationFormEvent.RepeatedPasswordChanged(it))
            },
            isError = state.repeatedPasswordError != null,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Repeated Password")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        if (state.repeatedPasswordError != null) {
            Text(
                text = state.repeatedPasswordError,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state.acceptedTerms,
                onCheckedChange = {
                    viewModel.onEvent(RegistrationFormEvent.AcceptTerms(it))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Accept terms"
            )
        }

        if (state.termsError != null) {
            Text(
                text = state.termsError,
                color = MaterialTheme.colors.error
            )
        }

        Button(
            onClick = {
                viewModel.onEvent(RegistrationFormEvent.Submit)
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Submit")
        }

    }
}
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.wilddisk.common.App
import ru.wilddisk.common.ui.Converter


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Column {
            App()
            Converter()
        }
    }
}

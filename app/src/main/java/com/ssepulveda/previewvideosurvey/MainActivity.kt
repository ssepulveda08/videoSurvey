package com.ssepulveda.previewvideosurvey

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ssepulveda.previewvideosurvey.ui.theme.PreviewVideosurveyTheme
import com.ssepulveda.videoSurvey.ui.listeners.VideoSurveyListener
import com.ssepulveda.videoSurvey.ui.models.Option
import com.ssepulveda.videoSurvey.ui.models.Questions
import com.ssepulveda.videoSurvey.ui.models.Survey
import com.ssepulveda.videoSurvey.ui.models.SurveyResponse
import com.ssepulveda.videoSurvey.ui.views.VideoBox

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewVideosurveyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VideoBox(
                        videoUri = "https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
                        survey = getSurvey(),
                        listener = object : VideoSurveyListener {
                            override fun onCompletedVideo(response: SurveyResponse) {
                                Toast.makeText(
                                    this@MainActivity,
                                    " Listener end Video ${response.response.first()?.id}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
                }
            }
        }
    }
}

private fun getSurvey(): Survey =  Survey(
    listOf(
        Questions(
            id = "56562526",
            title ="Lorem ipsum dolor sit, amet.",
            subTitle = "Lorem ipsum dolor sit amet consectetur, adipiscing elit cras.",
            presentTime = 2000,
            options = listOf(
                Option(
                    "1",
                    "Lorem ipsum dolor sit amet, "
                ),
                Option(
                    "2",
                    "Aenean sapien habitasse litora mauris."
                ),  Option(
                    "3",
                    "Aenean sapien habitasse litora mauris."
                ),
            )
        ),
    )
)


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PreviewVideosurveyTheme {
        Greeting("Android")
    }
}
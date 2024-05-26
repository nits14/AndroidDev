package com.ndk.simplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ndk.simplecompose.ui.theme.SimpleComposeProjectTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SimpleComposeProjectTheme {
                ProfileContent()
            }
        }
    }
}

@Composable
fun ProfileContent() {
    val isOpenProject = remember {
        mutableStateOf(false)
    }
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)

    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Divider()
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Nitesh Kamble",
                style = TextStyle(
                    color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.size(10.dp))
            Row {
                Image(
                    painter = painterResource(id = androidx.core.R.drawable.ic_call_answer_video), contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(Modifier.size(8.dp))
                Text(
                    text = "/nitesh14",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                    )
            }

            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Image(
                    painter = painterResource(id = androidx.core.R.drawable.ic_call_answer_video), contentDescription = null,
                    modifier = Modifier.size(28.dp)
                    )
                Spacer(Modifier.size(8.dp))
                Text(
                    text = "/nits1490",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.size(8.dp))
            Button(
                onClick = { isOpenProject.value = !isOpenProject.value },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Show Project ")
            }

            Spacer(modifier = Modifier.size(10.dp))

            if(isOpenProject.value){
                LazyColumn {
                    items(getProjectList()){
                        ProjectItem(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ProjectItem(project: Project) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile), contentDescription = null,
            Modifier
                .size(60.dp)
                .clip(CircleShape)
            )

        Column {
            Text(
                text = project.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = project.desc,
                style = MaterialTheme.typography.titleSmall

            )
        }
    }
}

data class Project(val name : String, val desc :String)

fun getProjectList() : List<Project>{
    return listOf(
     Project(name = "Social Media App", desc = "Connect with your friends") ,
     Project(name = "Media Player App", desc = "Listen Music endlessly")  ,
     Project(name = "Gaming Media", desc = "God of war Ragnarok lover")   ,
     Project(name = "Productivity App", desc = "Extra Productive important Apps")   ,
     Project(name = "Social Media App", desc = "Social Media Like Instagram, Facebook")
    )
}
private fun onShowProject(){

}

@Preview
@Composable
fun ProfileContentPreview() {
    ProfileContent()
}
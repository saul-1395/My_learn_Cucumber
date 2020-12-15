import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        //glue = "src/test/java/steps",
        glue = "src/test/java/steps",
       tags = "@test",

        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerTest {



}


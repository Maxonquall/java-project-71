package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;
/*import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;*/

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Parameters(index = "0", paramLabel = "filepath1", description = "path to 1st file.")
    private String filepath1;

    @Parameters(index = "1", paramLabel = "filepath2", description = "path to 2nd file.")
    private String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format = "format";

    @Override
    public Integer call() throws Exception {
        var diff = Differ.generate(filepath1, filepath2);
        System.out.println(diff);
        return 0;
    }


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }


}

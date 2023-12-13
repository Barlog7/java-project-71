package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import hexlet.code.Differ;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {


    @Parameters(index = "0", paramLabel="filepath1", description = "path to first file")
    String filepath1;

    @Parameters(index = "1", paramLabel="filepath2", description = "path to second file")
    String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel="format", description = "output format [default: stylish]")
    String format;

    /*@Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;*/

    public static void main(String[] args) {
        System.out.println("Hello World!");

/*        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            //System.exit(exitCode);
            return;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            //System.exit(exitCode);
            return;
        }*/
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
        //System.out.println("Hello World End");
    }

    @Override
    public Integer call() throws Exception {
        generate(filepath1, filepath2);
        return null;
    }
}

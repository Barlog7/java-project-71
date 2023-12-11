package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App {
/*    @Option(names={"-h", "--help"}, description="Display help/usage.", help=true)
    boolean help;
    @Option(names={"-V", "--version"}, description="Print version information and exit.", required=true)
    private String fileName;*/
    /*@Option(names = { "-h", "--help" }, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;*/
    /*@Option(names = {"-h", "--help"}, usageHelp = true,
        description = "Print usage help and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true,
            description = "Print version information and exit.")
    boolean versionHelpRequested;*/

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    /*@Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
            description = "Prints the checksum (SHA-256 by default) of a file to STDOUT.")*/
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
        System.out.println("Hello World End");
    }
}

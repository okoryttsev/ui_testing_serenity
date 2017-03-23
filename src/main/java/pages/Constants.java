package pages;

import java.util.logging.Logger;

/**
 * @author Sasha on 3/21/2017.
 */
public class Constants {
    private static final Logger LOGGER = Logger.getLogger( Constants.class.getName() );

    public static final String WAVE_RUN = "var waveExtensionPath = " +
            "'chrome-extension://jbbplnpkjmmeebjpijfedlgcdilocofh/';\n" +
            "var head = document.getElementsByTagName('head')[0];\n" +
            "var waveStyle = document.createElement('link');\n" +
            "var waveScript = document.createElement('script');\n" +
            "waveStyle.setAttribute('type', 'text/css');\n" +
            "waveStyle.setAttribute('rel', 'stylesheet');\n" +
            "waveStyle.setAttribute('href', waveExtensionPath + 'styles/report-ext.css');\n" +
            "waveScript.setAttribute('type', 'text/javascript');\n" +
            "waveScript.setAttribute('src', waveExtensionPath + 'wave.min.js');\n" +
            "head.appendChild(waveStyle);\n" +
            "head.appendChild(waveScript);";
}

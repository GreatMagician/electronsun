package util.test;

/**
 * Created by Alexander on 02.03.2017.
 */
public class StateUtils {
    //
    // Generates an HTML select list that can be used to select a specific
    // U.S. state.
    //
    public static String createStateSelectList()
    {
       // the value to assign from the state code, then the method parseSelectedState not needed
        return
                "<select name=\"state\">\n"
                        + "<option value=\"AL\">Alabama</option>\n"
                        + "<option value=\"AK\">Alaska</option>\n"
                        + "<option value=\"AZ\">Arizona</option>\n"
                        + "<option value=\"AR\">Arkansas</option>\n"
                        + "<option value=\"CA\">California</option>\n"
                        // more states here
                        + "</select>\n"
                ;
    }
    //
    // Displays the full name of the state specified by the two-letter code.
    //
    public static String displayStateFullName(String abbr)
    {
        if (abbr.equals("AL")) { return "Alabama";    }
        if (abbr.equals("AK")) { return "Alaska";     }
        if (abbr.equals("AZ")) { return "Arizona";    }
        if (abbr.equals("AR")) { return "Arkansas";   }
        if (abbr.equals("CA")) { return "California"; }
        // more states here
        return null;
    }
}

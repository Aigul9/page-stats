package parser;

import java.util.Map;

public class GetStats {
    public static void main(String[] args) {
//        Page page = new Page();
//        Delimiters delimiters = new Delimiters();
        Log logger = new Log();
//
//        Map<String, String> res = page.getPage();
//        String status = res.get("Status");
//        if (status.equals("Success")) {
//            String content = res.get("Content");
//            page.display(page.countWords(delimiters.splitPage(content)));
//        } else {
//            logger.logError(status);
//        }
//
        DB db = new DB();
        String db_res = db.connect();
        if (db_res == "OK") {
            System.out.println("OK");
        } else {
            logger.logError(db_res);
        }
    }
}

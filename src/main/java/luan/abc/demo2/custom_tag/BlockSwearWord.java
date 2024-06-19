package luan.abc.demo2.custom_tag;

import jakarta.servlet.jsp.JspContext;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.*;

import java.io.IOException;

public class BlockSwearWord extends SimpleTagSupport {
    private String content;
    String[] swearWords = new String[]{
            "Fuck",
            "Damn"
    };

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String text = this.content;
        for (int i = 0; i < swearWords.length; i++) {
            text = text.replaceAll(swearWords[i], "...");
        }
        getJspContext().getOut().write(text);
    }
}

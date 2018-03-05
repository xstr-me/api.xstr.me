package me.xstr.api.batch.readers;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class ImdbTsvDelimitedLineTokenizer extends DelimitedLineTokenizer {

    public ImdbTsvDelimitedLineTokenizer() {
		super(DelimitedLineTokenizer.DELIMITER_TAB);
	}

	@Override
    protected boolean isQuoteCharacter(char c) {
        return false;
    }

}

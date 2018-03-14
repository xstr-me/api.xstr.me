package me.xstr.api.models;

import me.xstr.api.models.imdb.ImdbMedia;

public enum MediaType {
	MOVIE("movie") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new Movie(imdbMedia);
        }
    },
    TV_MOVIE("tvMovie") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new Movie(imdbMedia);
        }
    },
    TV_SPECIAL("tvSpecial") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new Movie(imdbMedia);
        }
    },
    TV_SERIES("tvSeries") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new TvShow(imdbMedia);
        }
    },
    TV_MINI_SERIES("tvMiniSeries") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new TvShow(imdbMedia);
        }
    },
    SHORT("short") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new ShortMovie(imdbMedia);
        }
    },
    TV_SHORT("tvShort") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new ShortMovie(imdbMedia);
        }
    },
    TV_EPISODE("tvEpisode") {
        @Override
        public XstrMedia getXstrMedia(ImdbMedia imdbMedia) {
            return new TvEpisode(imdbMedia);
        }
    };

    String type;


    MediaType(String type) {
        this.type = type;
    }

    public static MediaType getBySymbole(String symbole) {
        for (MediaType type : MediaType.values()) {
            if (type.getType().equals(symbole)) {
                return type;
            }
        }
        return null;
    }


    public String getType() {
        return type;
    }


    public abstract XstrMedia getXstrMedia(ImdbMedia imdbMedia);
    
    public static class Values {
        public static final String MOVIE = "mv";
        public static final String TV_SHOW = "tv";
        public static final String SHORT_MOVIE = "sm";
        public static final String EPISODE = "ep";
    }
}



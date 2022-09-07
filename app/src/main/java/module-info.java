module telepodcast.app {
    requires org.slf4j;
    requires reload4j;
    requires jcommander;
    requires com.googlecode.lanterna;
    requires emoji.java;
    requires lombok;
    requires transitive telepodcast.telegram;
    requires transitive telepodcast.youtubedl;
}

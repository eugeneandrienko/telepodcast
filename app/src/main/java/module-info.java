module telepodcast.app {
    requires org.slf4j;
    requires ch.qos.reload4j;
    requires com.beust.jcommander;
    requires com.googlecode.lanterna;
    requires com.vdurmont.emoji;
    requires lombok;
    requires transitive telepodcast.telegram;
    requires transitive telepodcast.youtubedl;
}

package com.eugene_andrienko.telepodcast.tui;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DownloadOptions
{
    private String url;
    private String title;
    private DownloadType downloadType;
    private boolean isDownload;

    public enum DownloadType
    {
        AUDIO, VIDEO;

        private static final Map<Integer, DownloadType> idDownloadTypeMapping = new HashMap<>();
        static
        {
            for(DownloadType type : DownloadType.values())
            {
                idDownloadTypeMapping.put(type.ordinal(), type);
            }
        }

        public static DownloadType get(int id)
        {
            return idDownloadTypeMapping.get(id);
        }
    }
}

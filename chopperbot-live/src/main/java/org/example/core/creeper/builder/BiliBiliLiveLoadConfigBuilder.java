package org.example.core.creeper.builder;

import org.example.bean.Live;
import org.example.bean.live.BiliBiliLive;
import org.example.constpool.ConstPool;
import org.example.core.creeper.loadconfig.BilibiliLiveOnlineConfig;
import org.example.core.creeper.loadconfig.LoadLiveConfig;
import org.example.core.manager.CommonLoadConfigBuilder;
import org.example.pool.LiveModuleConstPool;
import org.springframework.stereotype.Component;

/**
 * @author Genius
 * @date 2023/09/05 19:18
 **/
@Component
public class BiliBiliLiveLoadConfigBuilder extends CommonLoadConfigBuilder<BilibiliLiveOnlineConfig> {
    @Override
    public String getName() {
        return "bilibili_live";
    }

    @Override
    public BilibiliLiveOnlineConfig build(Object obj) {
        if(obj instanceof BiliBiliLive){
            String liveId = ((BiliBiliLive) obj).getLiveId();
            String liver = ((BiliBiliLive) obj).getLiver();
            String path = LiveModuleConstPool.getPlatformLiveSavePath(ConstPool.PLATFORM.BILIBILI);
            BilibiliLiveOnlineConfig bilibiliLiveOnlineConfig = new BilibiliLiveOnlineConfig(liveId, path, LoadLiveConfig.fileName(liveId, liver), true);
            bilibiliLiveOnlineConfig.setShowDownloadTable(true);
            bilibiliLiveOnlineConfig.setLiverName(liver);
            bilibiliLiveOnlineConfig.setRoomName(((BiliBiliLive) obj).getLiveName());
            return bilibiliLiveOnlineConfig;
        }
        return null;
    }
}
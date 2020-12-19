package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.entity.Score
import top.vuhe.database.mapper.ScoreMapper
import top.vuhe.database.portal.service.intf.ScoreService

@Service("ScoreService")
class ScoreServiceImpl: ServiceImpl<ScoreMapper, Score>(), ScoreService {
}
package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionMember is a Querydsl query type for MissionMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionMember extends EntityPathBase<MissionMember> {

    private static final long serialVersionUID = 76346618L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionMember missionMember = new QMissionMember("missionMember");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> completedAt = createDateTime("completedAt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QMission mission;

    public final EnumPath<umc.spring.domain.enums.MissionState> state = createEnum("state", umc.spring.domain.enums.MissionState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMissionMember(String variable) {
        this(MissionMember.class, forVariable(variable), INITS);
    }

    public QMissionMember(Path<? extends MissionMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionMember(PathMetadata metadata, PathInits inits) {
        this(MissionMember.class, metadata, inits);
    }

    public QMissionMember(Class<? extends MissionMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new umc.spring.domain.QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}


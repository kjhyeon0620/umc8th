package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1366956614L;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    public final ListPath<Alarm, QAlarm> alarmList = this.<Alarm, QAlarm>createList("alarmList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final NumberPath<Integer> birthDay = createNumber("birthDay", Integer.class);

    public final NumberPath<Integer> birthMonth = createNumber("birthMonth", Integer.class);

    public final NumberPath<Integer> birthYear = createNumber("birthYear", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.spring.domain.enums.Gender> gender = createEnum("gender", umc.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactivateDate = createDate("inactivateDate", java.time.LocalDate.class);

    public final ListPath<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.domain.mapping.MemberPrefer.class, umc.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MissionMember, umc.spring.domain.mapping.QMissionMember> missionMemberList = this.<umc.spring.domain.mapping.MissionMember, umc.spring.domain.mapping.QMissionMember>createList("missionMemberList", umc.spring.domain.mapping.MissionMember.class, umc.spring.domain.mapping.QMissionMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final BooleanPath phoneVerified = createBoolean("phoneVerified");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.Role> role = createEnum("role", umc.spring.domain.enums.Role.class);

    public final EnumPath<umc.spring.domain.enums.MemberState> state = createEnum("state", umc.spring.domain.enums.MemberState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath username = createString("username");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}


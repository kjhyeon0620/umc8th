package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreCategory is a Querydsl query type for StoreCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreCategory extends EntityPathBase<StoreCategory> {

    private static final long serialVersionUID = 259587763L;

    public static final QStoreCategory storeCategory = new QStoreCategory("storeCategory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.Store, umc.spring.domain.QStore> storeList = this.<umc.spring.domain.Store, umc.spring.domain.QStore>createList("storeList", umc.spring.domain.Store.class, umc.spring.domain.QStore.class, PathInits.DIRECT2);

    public final EnumPath<umc.spring.domain.enums.FoodCategory> type = createEnum("type", umc.spring.domain.enums.FoodCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreCategory(String variable) {
        super(StoreCategory.class, forVariable(variable));
    }

    public QStoreCategory(Path<? extends StoreCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreCategory(PathMetadata metadata) {
        super(StoreCategory.class, metadata);
    }

}


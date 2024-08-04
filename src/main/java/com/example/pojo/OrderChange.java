package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lh
 * @since 2024-05-04
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("order_change")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderChange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private LocalDateTime oldStartTime;

    private LocalDateTime oldEndTime;

    private Integer oldTotal;

    private Integer changeOrderId;


}

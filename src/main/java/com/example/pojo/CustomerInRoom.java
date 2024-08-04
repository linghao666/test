package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lh
 * @since 2024-05-03
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("customer_in_room")
@Builder
public class CustomerInRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roomId;

    private Integer customerId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;


}

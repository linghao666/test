package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@Builder
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer roomId;

    private Integer customerId;

    private Integer total;

    private LocalDateTime payTime;

    private Integer userId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;


}
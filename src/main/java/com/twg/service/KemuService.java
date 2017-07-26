package com.twg.service;

import com.twg.entity.Kemu;
import com.twg.repository.KemuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tenvin on 2017/7/26.
 */

public interface KemuService extends BaseService<Kemu,Long>{

}

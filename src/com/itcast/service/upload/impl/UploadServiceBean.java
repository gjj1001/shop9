package com.itcast.service.upload.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.service.base.DaoSupport;
import com.itcast.service.upload.UploadService;
@Service @Transactional
public class UploadServiceBean extends DaoSupport implements UploadService {

}

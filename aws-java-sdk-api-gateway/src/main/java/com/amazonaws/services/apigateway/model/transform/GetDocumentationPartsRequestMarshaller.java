/*
 * Copyright 2012-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.amazonaws.services.apigateway.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.apigateway.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.util.StringUtils;

import com.amazonaws.protocol.json.*;

/**
 * GetDocumentationPartsRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class GetDocumentationPartsRequestMarshaller implements Marshaller<Request<GetDocumentationPartsRequest>, GetDocumentationPartsRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public GetDocumentationPartsRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<GetDocumentationPartsRequest> marshall(GetDocumentationPartsRequest getDocumentationPartsRequest) {

        if (getDocumentationPartsRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetDocumentationPartsRequest> request = new DefaultRequest<GetDocumentationPartsRequest>(getDocumentationPartsRequest, "AmazonApiGateway");

        request.setHttpMethod(HttpMethodName.GET);

        String uriResourcePath = "/restapis/{restapi_id}/documentation/parts";

        uriResourcePath = com.amazonaws.transform.PathMarshallers.NON_GREEDY.marshall(uriResourcePath, "restapi_id",
                getDocumentationPartsRequest.getRestApiId());
        request.setResourcePath(uriResourcePath);

        if (getDocumentationPartsRequest.getType() != null) {
            request.addParameter("type", StringUtils.fromString(getDocumentationPartsRequest.getType()));
        }

        if (getDocumentationPartsRequest.getNameQuery() != null) {
            request.addParameter("name", StringUtils.fromString(getDocumentationPartsRequest.getNameQuery()));
        }

        if (getDocumentationPartsRequest.getPath() != null) {
            request.addParameter("path", StringUtils.fromString(getDocumentationPartsRequest.getPath()));
        }

        if (getDocumentationPartsRequest.getPosition() != null) {
            request.addParameter("position", StringUtils.fromString(getDocumentationPartsRequest.getPosition()));
        }

        if (getDocumentationPartsRequest.getLimit() != null) {
            request.addParameter("limit", StringUtils.fromInteger(getDocumentationPartsRequest.getLimit()));
        }

        request.setContent(new ByteArrayInputStream(new byte[0]));
        if (!request.getHeaders().containsKey("Content-Type")) {
            request.addHeader("Content-Type", protocolFactory.getContentType());
        }

        return request;
    }

}
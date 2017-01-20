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
package com.amazonaws.services.rekognition.model.transform;

import java.io.ByteArrayInputStream;

import java.util.List;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * DeleteFacesRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class DeleteFacesRequestMarshaller implements Marshaller<Request<DeleteFacesRequest>, DeleteFacesRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public DeleteFacesRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<DeleteFacesRequest> marshall(DeleteFacesRequest deleteFacesRequest) {

        if (deleteFacesRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<DeleteFacesRequest> request = new DefaultRequest<DeleteFacesRequest>(deleteFacesRequest, "AmazonRekognition");
        request.addHeader("X-Amz-Target", "RekognitionService.DeleteFaces");

        request.setHttpMethod(HttpMethodName.POST);

        request.setResourcePath("");

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();

            jsonGenerator.writeStartObject();

            if (deleteFacesRequest.getCollectionId() != null) {
                jsonGenerator.writeFieldName("CollectionId").writeValue(deleteFacesRequest.getCollectionId());
            }

            java.util.List<String> faceIdsList = deleteFacesRequest.getFaceIds();
            if (faceIdsList != null) {
                jsonGenerator.writeFieldName("FaceIds");
                jsonGenerator.writeStartArray();
                for (String faceIdsListValue : faceIdsList) {
                    if (faceIdsListValue != null) {
                        jsonGenerator.writeValue(faceIdsListValue);
                    }
                }
                jsonGenerator.writeEndArray();
            }

            jsonGenerator.writeEndObject();

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            request.addHeader("Content-Type", protocolFactory.getContentType());
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
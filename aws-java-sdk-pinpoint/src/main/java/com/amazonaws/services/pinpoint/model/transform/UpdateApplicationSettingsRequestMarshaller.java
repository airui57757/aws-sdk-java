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
package com.amazonaws.services.pinpoint.model.transform;

import java.io.ByteArrayInputStream;

import javax.annotation.Generated;

import com.amazonaws.SdkClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.pinpoint.model.*;
import com.amazonaws.transform.Marshaller;

import com.amazonaws.protocol.json.*;

/**
 * UpdateApplicationSettingsRequest Marshaller
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UpdateApplicationSettingsRequestMarshaller implements Marshaller<Request<UpdateApplicationSettingsRequest>, UpdateApplicationSettingsRequest> {

    private final SdkJsonMarshallerFactory protocolFactory;

    public UpdateApplicationSettingsRequestMarshaller(SdkJsonMarshallerFactory protocolFactory) {
        this.protocolFactory = protocolFactory;
    }

    public Request<UpdateApplicationSettingsRequest> marshall(UpdateApplicationSettingsRequest updateApplicationSettingsRequest) {

        if (updateApplicationSettingsRequest == null) {
            throw new SdkClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateApplicationSettingsRequest> request = new DefaultRequest<UpdateApplicationSettingsRequest>(updateApplicationSettingsRequest,
                "AmazonPinpoint");

        request.setHttpMethod(HttpMethodName.PUT);

        String uriResourcePath = "/v1/apps/{application-id}/settings";

        uriResourcePath = com.amazonaws.transform.PathMarshallers.NON_GREEDY.marshall(uriResourcePath, "application-id",
                updateApplicationSettingsRequest.getApplicationId());
        request.setResourcePath(uriResourcePath);

        try {
            final StructuredJsonGenerator jsonGenerator = protocolFactory.createGenerator();

            WriteApplicationSettingsRequest writeApplicationSettingsRequest = updateApplicationSettingsRequest.getWriteApplicationSettingsRequest();
            if (writeApplicationSettingsRequest != null) {
                jsonGenerator.writeStartObject();
                if (writeApplicationSettingsRequest.getLimits() != null) {
                    jsonGenerator.writeFieldName("Limits");
                    CampaignLimitsJsonMarshaller.getInstance().marshall(writeApplicationSettingsRequest.getLimits(), jsonGenerator);
                }
                if (writeApplicationSettingsRequest.getQuietTime() != null) {
                    jsonGenerator.writeFieldName("QuietTime");
                    QuietTimeJsonMarshaller.getInstance().marshall(writeApplicationSettingsRequest.getQuietTime(), jsonGenerator);
                }
                jsonGenerator.writeEndObject();
            }

            byte[] content = jsonGenerator.getBytes();
            request.setContent(new ByteArrayInputStream(content));
            request.addHeader("Content-Length", Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type", protocolFactory.getContentType());
            }
        } catch (Throwable t) {
            throw new SdkClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}

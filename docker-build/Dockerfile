FROM registry.access.redhat.com/ubi8/openjdk-17:1.14-10.1675788279
USER root
RUN microdnf -y install zip
USER jboss

# install allure
RUN curl -O https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/2.21.0/allure-commandline-2.21.0.zip
RUN unzip  allure-commandline-2.21.0.zip
ENV PATH="/home/jboss/allure-2.21.0/bin:${PATH}"



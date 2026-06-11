# CI/CD Pipeline with Spring Boot & Kubernetes

A complete CI/CD implementation deploying a Spring Boot microservice to AWS EKS via GitHub Actions.

## Features
- Spring Boot REST API for product management
- Automated build and containerization
- Kubernetes deployment on AWS EKS
- GitHub Actions CI/CD pipeline

## Prerequisites
- Java 26
- Docker
- kubectl
- AWS account with EKS cluster
- GitHub repository

## Quick Start
1. Create your own Kubernetes cluster using AWS EKS service. use eksctl tool to create cluster on AWS EKS through command prompt.
   Use chocolatey to install the eksctl tool.
   
   Install Chocolatey - https://chocolatey.org/install (for windows)
   
   To install eksctl on Windows using Chocolatey, execute your command in an elevated terminal (Run as Administrator)
   
   choco install eksctl -y
   
   Verify the installation by running the following command - eksctl version
   
   Create cluster using eksctl tool --> eksctl create cluster --name my-first-cluster --region us-east-1 --nodes 2
   
   Here "my-first-cluster" is the name of the cluster.

   Documentation Links:
   
   https://docs.aws.amazon.com/eks/latest/eksctl/what-is-eksctl.html
   
   https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html

## Architecture
[diagram or description]

## API Endpoints

### 1. Get All Products with Pod Information
**Endpoint:** `GET /products`

**Description:** Returns a list of all products along with the Kubernetes pod name and namespace where the request was processed.

**Local Testing:**
```
http://localhost:8080/products
```

**AWS EKS (Cloud):**
```
http://<service-load-balancer-url>:8080/products
```
<img width="1477" height="260" alt="image" src="https://github.com/user-attachments/assets/63fef5b5-0be3-4b50-b794-58035744cfb5" />


**Response Example:**
```json
{
  "podName": "spring-boot-products-5d4f7c8b9-abc12",
  "podNamespace": "default",
  "products": [
    {
      "id": 1,
      "name": "Widget",
      "description": "Small widget for daily use",
      "price": 19.99
    },
    {
      "id": 2,
      "name": "Gadget",
      "description": "Multi-purpose gadget",
      "price": 29.95
    },
    {
      "id": 3,
      "name": "Thingamajig",
      "description": "Useful thingamajig",
      "price": 14.50
    }
  ]
}
```

**Response Fields:**
- `podName` - The Kubernetes pod name where the application is running
- `podNamespace` - The Kubernetes namespace (default is "default")
- `products` - Array of product objects with id, name, description, and price

---

### 2. Get Server Configuration
**Endpoint:** `GET /server/config`

**Description:** Returns the pod name and namespace information for the running application.

**Local Testing:**
```
http://localhost:8080/server/config
```

**AWS EKS (Cloud):**
```
http://<service-load-balancer-url>:8080/server/config
```

**Response Example:**
```json
{
  "podName": "spring-boot-products-5d4f7c8b9-abc12",
  "podNamespace": "default"
}
```

**Use Case:** Useful for debugging and verifying which pod/replica processed your request in a multi-replica deployment.

## Deployment
[how the pipeline works]

Test Code → Build & Push Docker → Deploy to EKS
   ✓           ✓                    ✓
 (Gradle)    (Docker Image)    (Kubernetes)

## Troubleshooting
[common issues]
1. Deploy-EKS job failed - Process completed with exit code 254.
<img width="1630" height="742" alt="image" src="https://github.com/user-attachments/assets/46a79d09-d1f4-4953-98da-f84f5ffdf880" />

Run aws eks update-kubeconfig --name my-first-cluster --region us-east-1

Error: aws: [ERROR]: An error occurred (ResourceNotFoundException) when calling the DescribeCluster operation: No cluster found for name: my-first-cluster

**Solution** : Refer the Quick start section and create your own Kubernetes cluster.

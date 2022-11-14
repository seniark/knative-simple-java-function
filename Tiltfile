# You will need to modify this file to enable Tilt live debugging
SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='source-image-location') # CHANGEME - replace `source-image-location` with your writable repository
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='default')
OUTPUT_TO_NULL_COMMAND = os.getenv("OUTPUT_TO_NULL_COMMAND", default=' > /dev/null ')

allow_k8s_contexts('your-k8s-context') # CHANGEME - replace `your-k8s-context` with your targeted Kubernetes context

k8s_custom_deploy(
    'test-java-faas',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --live-update" +
        " --local-path " + LOCAL_PATH +
        " --source-image " + SOURCE_IMAGE +
        " --namespace " + NAMESPACE +
        " --yes " +
        OUTPUT_TO_NULL_COMMAND +
        " && kubectl get workload test-java-faas --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes" ,
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
        sync('./target/classes', '/workspace')
    ]
)

k8s_resource('test-java-faas', port_forwards=["8080:8080"],
    extra_pod_selectors=[{'serving.knative.dev/service': 'test-java-faas'}])

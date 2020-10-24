import os


def get_dirs(path='.'):
    """

    :param path:
    :return:
    """
    compilable_files = {}
    for a, b, c in os.walk(os.getcwd()):
        if "src" in a:
            compilable_files[a] = [os.path.join(a, _file) for _file in c]
    print(compilable_files)
    return compilable_files
